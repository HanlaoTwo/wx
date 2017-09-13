import paramiko

#服务器信息
IP = '45.63.11.158'
USER = 'root'
PASSWORD = 'Em5!EJ{pxPJq+Y*V'

#文件信息
file_update = 'textchat.js'
REMORE_PATH = '/usr/software/apache-tomcat-8.5.15/webapps/wx-1.0/WEB-INF/classes/scripts/'
LOCAL_PATH = 'textchat.js'
cmd_rm = 'rm '+REMORE_PATH+file_update

#删除
s = paramiko.SSHClient()
s.set_missing_host_key_policy(paramiko.AutoAddPolicy())
s.connect(hostname=IP, username=USER, password=PASSWORD)
out_rm = s.exec_command(cmd_rm)
s.close

#上传
t = paramiko.Transport((IP,22))
t.connect(username=USER,password=PASSWORD)
s = paramiko.SFTPClient.from_transport(t)
s.put(LOCAL_PATH,REMORE_PATH+file_update)
t.close
