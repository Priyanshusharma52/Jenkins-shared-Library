def call(String imageName, String imagetag) {
echo "Building Docker Image: ${imageName}"
sh "docker build -t ${imageName}:${imagetag} ."
}
