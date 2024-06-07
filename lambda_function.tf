resource "aws_lambda_function" "example" {
  function_name = "ARQUITETURACPU"
  handler       = "com.example.LambdaFunctionHandler::handleRequest"
  runtime       = "java11"
  role          = aws_iam_role.lambda_role.arn
  filename      = "my-java-lambda.zip"

  source_code_hash = filebase64sha256("my-java-lambda.zip")

  architectures = [var.architecture]

  environment {
    variables = {
      EXAMPLE_VARIABLE = "Environment Test"
    }
  }

  timeout = 60  # Define o timeout para 60 segundos
}
