def call() {
    def mvnTool = isUnix() ? 'sh' : 'bat'
    "${mvnTool}" 'mvn test'
}
