output "ecr_repo_url" {
  value = module.ecr.app_repo_url
}

output "ecs_cluster_name" {
  value = module.ecs.ecs_cluster_name
}