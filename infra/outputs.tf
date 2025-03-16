output "ecr_repository_url" {
  value = aws_ecr_repository.app_repo.repository_url
}

output "load_balancer_dns" {
  value = aws_lb.app_lb.dns_name
}

output "ecs_cluster_name" {
  value = aws_ecs_cluster.main.name
}

output "ecs_service_name" {
  value = aws_ecs_service.app_service.name
}