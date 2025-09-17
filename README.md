# 3DWestern Dashboard Backend

RESTful API backend to handle user management and print-job submission for the 3DW x Morrissette makerspace 3D printing farm.

## Technology
Club website
- TypeScript / JavaScript
- Next.js
- TailwindCSS
- MongoDB

Dashboard front-end
- TypeScript
- Vite (SSR)
- TailwindCSS
- ShadCN
- Docker

**Dashboard back-end**
- **Kotlin**
- **Spring Boot**
- **JPA**
- **MariaDB**
- **Docker**

AI pipeline
- Docker
- n8n
- Google Gemini
- Python
- JavaScript

## Schema
User
- studentId: Integer
  - Primary key; user's UWO student number
  - For safety and security, It is important to tie the user's identity to their account to hold them accountable for their prints 
- email: String
  - User's UWO student email
- firstName: String
- lastName: String
- passwordHash: String
  - Passwords hashed using bcrypt
- createdDate: Date 
- status: MEMBER | ADMIN | BLACKLISTED
- trainingLevel: [0, 3]
  - Based on the [Morrissette Makerspace Certification System](https://docs.google.com/document/d/1BhJQCVIhRCy1AYST519PUZ_b0Vc8GFs1n7x9s-9-bqk/edit?tab=t.0)

Print Job
- id: GUID
- studentId: Integer
  - Foreign key pointing to a User record
  - Each Print Job is associated with a single User. This is a (1:n) relationship
- filePath: String
- orderPlaced: Date
- status: IN_QUEUE | PRINTING | READY | FLAGGED | ERROR
  - Flags denoting the current status of a print job. FLAGGED means the AI pipeline flagged the model for manual review, ERROR means that something went wrong during the printing process
- description: String
  - Describes what the model is. Provides additional context for the language model in the pipeline
- name: String
- reprint: UUID | null
  - If this print job is a reprint of a past request, this field stores a pointer to the original print job as a foreign key
  - If not, then this field is null

Completed Order
- id: GUID
- studentId: Integer
    - Foreign key pointing to a User record
    - Each Print Job is associated with a single User. This is a (1:n) relationship
- filePath: String
- orderPlaced: Date
- orderFinished: Date
- status: SUCCESS | FAIL
    - Flags denoting the result of a finished print
- description: String
    - Describes what the model is. Provides additional context for the language model in the pipeline
- name: String
- reprint: UUID | null
    - If this print job is a reprint of a past request, this field stores a pointer to the original print job as a foreign key
    - If not, then this field is null

## Endpoints

GET: `api/v0/users/all`
- Retrieve list of all user accounts

GET: `api/v0/users/{id}`
- Retrieve user account by student ID

POST: `api/v0/users`
- Create a new user to store in the DB

DELETE: `api/v0/users/{id}`
- Delete a user account from DB by stduent ID