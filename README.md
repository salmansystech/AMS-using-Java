# Attendance Management System (AMS) - Java

A desktop-based attendance management system for educational institutions, built with Java Swing. This application provides role-based access for administrators, teachers, and students to manage attendance records efficiently.

## Features

- **Role-Based Access Control**: Separate login and interfaces for Admin, Teacher, and Student roles
- **Student Management**: Add, view, update, and delete student records
- **Teacher Management**: Manage teacher information and assignments
- **Subject Management**: Create and manage subjects and course assignments
- **Attendance Tracking**: Record and track student attendance per class/subject
- **Record Viewing**: Query and view attendance records with filtering options
- **Data Persistence**: File-based data storage for persistent record management
- **User-Friendly GUI**: Intuitive Swing-based interface for easy navigation

## Technology Stack

- **Language**: Java 11+
- **UI Framework**: Java Swing (JFrame, JPanel)
- **Build Tool**: CMake/Javac
- **Data Storage**: File-based persistence
- **Architecture**: MVC-inspired modular design

## System Requirements

- Java Runtime Environment (JRE) 11 or higher
- 100 MB free disk space
- Windows, Linux, or macOS

## Installation

### Compile from Source

```bash
# Navigate to project directory
cd Attendance\ project/

# Compile all Java files
javac -d bin *.java

# Run the application
java -cp bin Main
```

### Using CMake (Optional)

```bash
mkdir build
cd build
cmake ..
make
./AMS
```

## Usage

### Admin
1. Login with admin credentials
2. Manage students, teachers, and subjects
3. View system-wide attendance reports
4. Configure system settings

### Teacher
1. Login with teacher credentials
2. Record student attendance for assigned classes
3. View attendance records for your classes
4. Generate attendance reports

### Student
1. Login with student credentials
2. View your own attendance records
3. Check attendance status per subject
4. Download attendance certificates (if available)

## Project Structure

```
Attendance project/
├── Main.java                 # Application entry point
├── LoginFrame.java          # Authentication module
├── AddStudent.java          # Student management UI
├── AddTeacher.java          # Teacher management UI
├── AddSubject.java          # Subject management UI
├── AttendanceFrame.java     # Attendance recording UI
├── ViewRecords.java         # Record viewing module
└── data/                    # Data storage directory
```

## Key Components

- **Login System**: Validates user credentials and determines access level
- **Database Module**: Handles file-based data operations
- **GUI Components**: Reusable Swing components for data entry and display
- **Validation Engine**: Ensures data integrity and prevents invalid entries

## Building and Running

### Quick Start
```bash
javac Attendance\ project/*.java
java -cp Attendance\ project Main
```

### With Maven (if pom.xml exists)
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
```

## Configuration

Edit `build.properties` to customize:
- Java version requirement
- Output directory
- Source encoding

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on:
- Code style standards
- Development setup
- Testing procedures
- Commit message format

## Changelog

See [CHANGELOG.md](CHANGELOG.md) for version history and feature updates.

## License

This project is open source. See LICENSE file for details.

## Future Enhancements

- [ ] Database integration (MySQL/PostgreSQL)
- [ ] Web-based interface
- [ ] Mobile app support
- [ ] Advanced reporting and analytics
- [ ] Email notifications
- [ ] Biometric integration

## Troubleshooting

### Application won't start
- Ensure Java 11+ is installed: `java -version`
- Check all Java files are compiled in bin directory
- Verify file permissions

### Data not persisting
- Check write permissions in data directory
- Ensure sufficient disk space
- Verify file paths in configuration

## Support

For issues or feature requests, please create an issue in the repository.

## Author

Salman Khan - [GitHub Profile](https://github.com/salmansystech)

## Acknowledgments

- Java Swing documentation and tutorials
- Educational institutions that inspired this project
- Contributors and testers
