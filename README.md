# Employee Salaries Data Management

Welcome to the Employee Salaries Management System. Here, you can manage and analyze employee data through a CSV file input.

## CSV File Details

**Structure:**

| Employee ID | Name        | Department | Role         | Salary | City    | Education | Joining Date |
|-------------|-------------|------------|--------------|--------|---------|-----------|--------------|
| *number*    | *string*    | *string*   | *string*     | *number* | *string* | *string*  | *dd/MM/yy*   |

**Sample Data:**

| Employee ID | Name       | Department | Role        | Salary | City      | Education      | Joining Date |
|-------------|------------|------------|-------------|--------|-----------|----------------|--------------|
| 1001        | John Doe   | HR         | Manager     | 75000  | New York  | MBA            | 01/01/22     |
| 1002        | Jane Smith | IT         | Developer   | 80000  | San Diego | B.Tech         | 15/05/21     |

## File Contents

Here is a brief overview of what you might find in the CSV:

- **Employee ID**: Unique identifier for each employee.
- **Name**: Full name of the employee.
- **Department**: The department within the organization the employee works for.
- **Role**: The job title or position of the employee.
- **Salary**: Annual compensation of the employee in local currency.
- **City**: City where the employee is based or works from.
- **Education**: Highest level of education completed by the employee.
- **Joining Date**: The date the employee started working at the company.

### Download the CSV

You can download or view the sample CSV file below:

[Sample CSV File](src/main/resources/employee_salaries.csv)

## Optional Info

### API Endpoint for CSV Upload

**POST:** `http://localhost:8090/api/upload`

- **Request:** Multipart form data where you can attach the `employee_salaries.csv` file.

**Example Request Body:**
```text
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="file"; filename="employee_salaries.csv"
Content-Type: text/csv

...CSV CONTENT...
------WebKitFormBoundary7MA4YWxkTrZu0gW--
```

**Linux Command to Call API:**
```
curl -X POST -F "file=<your-folder-location>/employee_salaries.csv" http://localhost:8090/api/upload
```
## Database Management
- **H2-Console:** Available at http://localhost:8090/h2-console/
- **JDBC URL:** jdbc:h2:mem:testdb
- **Username:** sa
- **Password:** (blank)

## SQL query
```
SELECT * FROM EMPLOYEE;
```
## API Documentation
- **Swagger UI:** Access the interactive documentation at http://localhost:8090/swagger-ui/index.html#
- **OpenAPI JSON:** View the OpenAPI description in JSON format at http://localhost:8090/v3/api-docs

## Official Documentation
For more details on how to use SpringDoc, refer to the official documentation at SpringDoc.

**Note:** Ensure that the path/to/your/sample.csv is replaced with the actual path or URL where your CSV file is hosted or located relative to your markdown file.

**Usage Instructions:**
To open the CSV: Click on the link above to download or directly view in your browser if supported.
To use in your project: You might need software like Microsoft Excel, Google Sheets, or any text editor to open and manipulate the CSV data.
