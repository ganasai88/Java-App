pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/ganasai88/Java-App.git' // GitHub repository URL4
        VENV_DIR = 'venv'
        ACCESS_KEY = credentials('AWS_ACCESS_KEY_ID')
        SECRET_KEY = credentials('AWS_SECRET_KEY_ID')
        REGION = 'us-east-2'
        S3_BUCKET = 'simplejavaapp01'
    }

    stages {
        stage('Checkout') {
            steps {

                git branch: 'main', url: "${REPO_URL}"

            }
        }

        stage('Upload Files to S3') {
            steps {
                 script {
                        sh '''

                            zip -r ${S3_BUCKET}.zip . --exclude "*.git*" --exclude ".git/*"

                            # Sync the code to S3, including all files and excluding .git directory
                            aws s3 sync . s3://${S3_BUCKET}/ --exact-timestamps --exclude ".git/*"

                            echo "Files uploaded successfully!"
                        '''
                 }
            }
        }
        stage('Unzip') {
            steps {
                 script {
                        sh '''
                            aws s3 cp s3://${S3_BUCKET}/${S3_BUCKET}.zip .
                            unzip -o ${S3_BUCKET}.zip -d .
                        '''
                 }
            }
        }
        stage('Build and Run Application') {
            steps {
                script {
                    // Navigate to the project folder, build with Maven, and run the application
                    sh '''
                        # Navigate to the project directory
                        # Clean and install using Maven
                        mvn clean install
                        # Run the application
                        java -jar target/simpleapp-0.0.1-SNAPSHOT.jar
                        echo "Application started successfully."
                    '''
                }
            }
        }
    }
}