# 3DWestern Dashboard Backend

RestfulAPI backend to handle user management and print-job submission for the 3DW x Morrissette makerspace print-farm.

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

## Schema
User
- id: Integer
  - Primary key; user's UWO student number
  - For safety and security, It is important to tie the user's identity to their account to hold them accountable for their prints 
- email: String
  - User's UWO student email
- firstName: String
- lastName: String
- passwordHash: String
  - Passwords hashed used bcrypt
- createdDate: Date 
- status: MEMBER | ADMIN | BLACKLISTED
- trainingLevel: [0, 3]
  - Based on the [Morrissette Makerspace Certification System](https://docs.google.com/document/d/1BhJQCVIhRCy1AYST519PUZ_b0Vc8GFs1n7x9s-9-bqk/edit?tab=t.0)

## Endpoints

GET: `api/v0/users/all`
- Retrieve list of all user accounts

GET: `api/v0/users/{id}`
- Retrieve user account by student ID

POST: `api/v0/users`
- Create a new user to store in the DB

DELETE: `api/v0/users/{id}`
- Delete a user account from DB by stduent ID