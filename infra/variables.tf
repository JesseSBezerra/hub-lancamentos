variable "aws_region" {
  description = "AWS Region"
  default     = "sa-east-1"
}

variable "app_name" {
  description = "Nome da aplicação"
  default     = "hub-lancamentos"
}

variable "vpc_cidr" {
  default = "10.0.0.0/16"
}

variable "public_subnet_cidrs" {
  type    = list(string)
  default = ["10.0.1.0/24", "10.0.2.0/24"]
}

variable "container_port" {
  default = 8080
}

variable "desired_count" {
  default = 1
}

variable "ecr_repo_name" {
  default = "hub-lancamentos"
}

variable "dynamodb_table_name" {
  default = "tbl_lancamento"
}