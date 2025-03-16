variable "region" { default = "sa-east-1" }
variable "app_name" { default = "js-ecs-confirmador" }
variable "ecr_image_url" { default = "397685870114.dkr.ecr.sa-east-1.amazonaws.com/hub-lancamentos:latest" }
variable "container_port" { default = 8080 }
variable "ecr_repo_name" { default = "hub-lancamentos" }
variable "desired_count" { default = 1 }