resource "aws_dynamodb_table" "lancamento_table" {
  name           = "tbl_lancamento"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "S"
  }
}
