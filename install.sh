echo "Installation is starting..."

# Install OpenJDK 8 for CentOS/RHEL 7/6/5
sudo yum install -y java-1.8.0-openjdk

# Verify the java installation
java -version

# Setup the JAVA_HOME environment variable
echo "JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")" | sudo tee -a /etc/profile
source /etc/profile
echo $JAVA_HOME

# Download and extract the Apache Maven 3.5 archive
cd
wget http://www-us.apache.org/dist/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.tar.gz
tar -zxvf apache-maven-3.5.3-bin.tar.gz

# Move all Apache Maven 3.5 files to a reasonable location and change their ownership to root:root:
sudo mv ~/apache-maven-3.5.3 /opt
sudo chown -R root:root /opt/apache-maven-3.5.3

# Create version-irrelevant symbolic link pointing to the original Apache Maven 3.5 directory
sudo ln -s /opt/apache-maven-3.5.3 /opt/apache-maven

# Add the path /opt/apache-maven to the PATH environment variable.
echo 'export PATH=$PATH:/opt/apache-maven/bin' | sudo tee -a /etc/profile
source /etc/profile

# Verify the installation
mvn --version

echo "Installation is done successfully!"
