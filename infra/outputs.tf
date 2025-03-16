output "ecs_service_name" {
  value = aws_ecs_service.app_service.name
}

output "cluster_name" {
  value = aws_ecs_cluster.ecs_cluster.name
}
