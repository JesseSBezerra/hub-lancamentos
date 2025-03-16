resource "aws_ecs_cluster" "hub_cluster" {
  name = "hub-central-cluster"
}

# Task Definition (resumido para exemplo)
resource "aws_ecs_task_definition" "hub_lancamentos_task" {
  family                   = "hub-lancamentos"
  requires_compatibilities = ["FARGATE"]
  network_mode            = "awsvpc"
  cpu                     = "512"
  memory                  = "1024"
  execution_role_arn      = aws_iam_role.ecs_task_execution_role.arn
  container_definitions   = jsonencode([
    {
      name      = "hub-lancamentos"
      image     = "<url-do-ecr-ou-image>"
      portMappings = [{
        containerPort = 8080
        hostPort      = 8080
      }]
      environment = [
        {
          name  = "SPRING_PROFILES_ACTIVE"
          value = "prod"
        }
      ]
    }
  ])
}

resource "aws_ecs_service" "hub_lancamentos_service" {
  name            = "hub-lancamentos-service"
  cluster         = aws_ecs_cluster.hub_cluster.id
  task_definition = aws_ecs_task_definition.hub_lancamentos_task.arn
  desired_count   = 1
  launch_type     = "FARGATE"
  network_configuration {
    subnets         = ["<subnet-id>"]
    security_groups = ["<security-group-id>"]
    assign_public_ip = true
  }
}
