module "network" {
  source = "./network"
  vpc_cidr = var.vpc_cidr
  public_subnet_cidrs = var.public_subnet_cidrs
}

module "ecr" {
  source = "./ecr"
  ecr_repo_name = var.ecr_repo_name
}

module "dynamodb" {
  source = "./dynamodb"
  dynamodb_table_name = var.dynamodb_table_name
}

module "ecs" {
  source = "./ecs"
  app_name = var.app_name
  container_port = var.container_port
  desired_count = var.desired_count
  subnet_ids = module.network.public_subnet_ids
  ecr_repo_url = module.ecr.ecr_repo_url
}