#tested on Amazon Linux 2
wget https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
sudo yum install epel-release-latest-7.noarch.rpm
sudo yum install -y stress

#stress --cpu 1 --io 4 --vm 2 --timeout 2m
