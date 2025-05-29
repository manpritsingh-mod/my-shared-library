println("Code Executed till here");
def call(){
    def mvnTool = isUnix() ? 'sh' : 'bat'
    "${mvnTool}" 'mvn clean install'
}
