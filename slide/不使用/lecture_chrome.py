import paramiko
import time
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager



# IPはsotaのボタンをクリックして確認して変更してください。
ip = input("Please Enter sotaIP: ")
lecture = input("Please Enter lecturename. control or exprimental: ")
slide_count = int(input("Please Enter number of slides: "))

browser = webdriver.Chrome()# webdriver_managerによるChromeDriverの更新。chromeDriverへのパスを入力
browser.get(".\lecture_"+lecture+"1.html")
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
ssh.connect(ip)
def Sota_Lecture(FileName):
    stdin, stdout, stderr = ssh.exec_command("cd lecture/bin && export PATH=/usr/local/bin:/usr/bin:/bin:/home/vstone/java/jdk1.8.0_40/bin:/usr/local/sbin:/usr/sbin:/sbin && chmod +x *.sh && ./java_run.sh jp/vstone/sotasample/"+FileName) #cdでは環境変数がおそらくrootのままになってしまうので、exportで変更しておく（でないと「javaが見つからない」と言われてしまう）
        # 実行結果を表示
        # stdoutは標準出力の正常結果，stderrは標準出力のエラーが出力
    for result in stdout:
        print('[std]', result, end='')
    for error in stderr:
        print('[err]', error, end='')

time.sleep(10) #スライド画面の準備時間
if lecture=="control":#統制群の場合
    for i in range(0,slide_count+1):
        # Sota_Lecture("social_lecture_control"+i)
        Sota_Lecture("Social_lecture_control"+str(i))
        browser.find_element_by_id("skip-btn").click()
elif lecture=="experimental":#実験群の場合
    for i in range(0,slide_count+1):
        Sota_Lecture("Social_lecture_experimental"+str(i))
        browser.find_element_by_id("skip-btn").click()
else:
    print("lecturename is wrong")

ssh.close()