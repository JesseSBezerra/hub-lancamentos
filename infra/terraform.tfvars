aws_region = "sa-east-1"
app_name = "hub-lancamentos"
vpc_cidr = "10.0.0.0/16"
public_subnet_cidrs = ["10.0.1.0/24", "10.0.2.0/24"]
container_port = 8080
desired_count = 1
ecr_repo_name = "hub-lancamentos"
dynamodb_table_name = "tbl_lancamento"