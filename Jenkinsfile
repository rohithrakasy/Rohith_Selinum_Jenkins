pipeline{
	agent any
	
	parameters{
		choice(
			name: 'BROWSER',
			choices:['chrome','firefox','edge'],
			description: 'Select the browser for test execution'
		)
	}
	
	
	tools{
		jdk 'JDK21'
		maven 'Maven-3.9.16'
	}
	
	stages{
		
		stage('Checkout'){
			steps{
				checkout scm
			}
		}
		
		stage('Verify Tools'){
			steps{
				bat 'java -version'
				bat 'mvn -version'
			}
		}
		
		stage('Run Selenium Tests'){
			steps{
				bat "mvn clean test -Dbrowser=${params.BROWSER}"
			}
		}
	}
	
	post {
    always {
        junit testResults: 'target/surefire-reports/*.xml',
              allowEmptyResults: true

        archiveArtifacts artifacts: 'reports/**/*.html, screenshots/**/*.png',
                         allowEmptyArchive: true

        publishHTML([
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: '*.html',
            reportName: 'Extent Report'
        ])
    }

    success {
        echo "OrangeHRM tests passed on ${params.BROWSER}."
    }

    failure {
        echo "OrangeHRM tests failed on ${params.BROWSER}."
    }
}
}