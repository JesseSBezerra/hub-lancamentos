terraform {
  backend "s3" {
    bucket         = "hub-lancamentos-terraform-state"
    key            = "env/terraform.tfstate"
    region         = "sa-east-1"
    dynamodb_table = "terraform-locks"
    encrypt        = true
  }
}
