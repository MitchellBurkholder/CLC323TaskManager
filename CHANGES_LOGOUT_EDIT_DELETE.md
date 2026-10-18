# CLC323 Task Manager — Changes

- Added conditional **Log Out** form to the shared navigation bar. Existing Spring Security `/logout` handler ends the session and redirects to `/login?logout`.
- Added **Edit** and **Delete** controls to each row on the Tasks page.
- Added GET `/Tasks/{id}/edit` and POST `/Tasks/{id}/edit` for loading/saving updates.
- Added POST `/Tasks/{id}/delete` with confirmation dialog.
- Added `id` to the task view model and get/update/delete service operations. Edits retain the original task's creation timestamp and ID.
- Fixed task create redirect and form validation paths, and corrected Cancel URLs.
- Existing logging statements were kept and new edit/delete logs were added.

## How to run / verify

1. Extract the ZIP, open `CLC-323-App/demo` in your IDE.
2. Set the MySQL connection variables `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` for your environment. Never commit database credentials.
3. On Windows run `mvnw.cmd clean package` or `mvnw.cmd spring-boot:run` (Java 17+).
4. Log in, create a task, use **Edit**, save your changes, use **Delete**, and select **Log Out**.
5. After verification, package and deploy the new application JAR to Elastic Beanstalk as your process requires.

Note: The sandbox did not have a functional Maven installation/wrapper distribution to complete a build, so compile and runtime checks on your workstation/AWS are still required. The database and cloud deployment were not changed here.

Security note: the uploaded project's pre-existing `SecurityConfig.java` disables CSRF protection. Consider enabling CSRF and verifying all forms before public production use.
