def Build(){
    def mvnTool = isUnix() ? 'sh' : 'bat'
    "${mvnTool}" 'mvn clean install'
}

def Test(){
    def mvnTool = isUnix() ? 'sh' : 'bat'
    "${mvnTool}" 'mvn test'
}
