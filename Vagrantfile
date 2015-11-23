# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.hostname = "jooq-java-time"
  config.vm.box = "ericmann/trusty64"
  
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "500"
    vb.cpus = 1
  end
  
  # runs as root within the VM
  config.vm.provision "shell", inline: %q{
  
    set -e  # stop on error

    echo --- General OS installation
    apt-get update
    DEBIAN_FRONTEND=noninteractive apt-get upgrade -q -y    # grub upgrade warnings mess with the terminal
    apt-get -q -y install vim maven ntp unattended-upgrades 

    echo --- Install Java 8
    echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" >> /etc/apt/sources.list.d/webupd8team-java.list
    echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" >> /etc/apt/sources.list.d/webupd8team-java.list
    apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
    apt-get update
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
    apt-get -qy install oracle-java8-installer

    echo --- PostgreSQL
    apt-get -qy install postgresql postgresql-contrib
    (cd /tmp && sudo -u postgres psql -c "alter user postgres password 'postgres'" postgres)  # os user postgres cannot see /root dir
    (cd /tmp && sudo -u postgres psql -c "create database jooqtest" postgres)  
    (cd /tmp && sudo -u postgres psql -1 -f /vagrant/src/main/resources/example-schema.sql jooqtest)  
  }
  
  config.vm.provision "shell", run: "always", inline: %q{
  
    set -e  # stop on error
    
    echo ''
    echo '-----------------------------------------------------------------'
    echo 'After "vagrant ssh", use:'
    echo '  mvn -f /vagrant/pom.xml clean install'
    echo '  psql -hlocalhost jooqtest postgres   (password postgres)'
    echo '-----------------------------------------------------------------'
    echo ''
  }
  
end
