terraform {
  backend "s3" {
    bucket         = "tfstate-hub-lancamentos"
    key            = "hub-lancamentos/terraform.tfstate"
    region         = "sa-east-1"
    dynamodb_table = "terraform-locks"
    encrypt        = true
  }
}