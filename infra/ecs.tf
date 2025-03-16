resource "aws_ecs_cluster" "main" {
  name = "hub-central-cluster"
}

resource "aws_iam_role" "ecs_task_execution_role" {
  name = "ecsTaskExecutionRole"
  assume_role_policy = data.aws_iam_policy_document.ecs_assume_role_policy.json
}

data "aws_iam_policy_document" "ecs_assume_role_policy" {
  statement {
    effect = "Allow"
    principals {
      type        = "Service"
      identifiers = ["ecs-tasks.amazonaws.com"]
    }
    actions = ["sts:AssumeRole"]
  }
}

resource "aws_iam_role_policy_attachment" "ecs_task_execution_policy" {
  role       = aws_iam_role.ecs_task_execution_role.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AmazonECSTaskExecutionRolePolicy"
}

resource "aws_ecs_task_definition" "hub_lancamentos_task" {
  family                   = "hub-lancamentos-task"
  requires_compatibilities = ["FARGATE"]
  cpu                      = "512"
  memory                   = "1024"
  network_mode             = "awsvpc"
  execution_role_arn       = aws_iam_role.ecs_task_execution_role.arn
  container_definitions    = jsonencode([{
    name  = "hub-lancamentos"
    image = "${aws_ecr_repository.hub_lancamentos.repository_url}:latest"
    portMappings = [{ containerPort = var.container_port }]
  }])
}

resource "aws_ecs_service" "app_service" {
  name            = "hub-lancamentos-service"
  cluster         = aws_ecs_cluster.main.id
  task_definition = aws_ecs_task_definition.hub_lancamentos_task.arn
  desired_count   = var.desired_count
  launch_type     = "FARGATE"
  network_configuration {
    subnets         = var.public_subnet_ids
    assign_public_ip = true
    security_groups  = [aws_security_group.ecs_sg.id]
  }
  load_balancer {
    target_group_arn = aws_lb_target_group.app_target_group.arn
    container_name   = "hub-lancamentos"
    container_port   = var.container_port
  }
  depends_on = [aws_lb_listener.app_listener]
}
