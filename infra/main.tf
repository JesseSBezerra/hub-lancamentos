provider "aws" {
  region = var.aws_region
}

terraform {
  backend "s3" {
    bucket         = "tfstate-hub-lancamentos"
    key            = "state/terraform.tfstate"
    region         = "sa-east-1"
    dynamodb_table = "terraform-locks"
  }
}

module "network" {
  source = "./network"
}

module "ecs" {
  source = "./ecs"
}

module "ecr" {
  source = "./ecr"
}

module "dynamodb" {
  source = "./dynamodb"
}