variable "aws_region" {}
variable "vpc_cidr" {}
variable "public_subnet_cidrs" { type = list(string) }
variable "app_name" {}
variable "container_port" {}
variable "desired_count" {}
variable "ecr_repo_name" {}
variable "dynamodb_table_name" {}