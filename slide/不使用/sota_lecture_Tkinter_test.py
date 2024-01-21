import paramiko
import time
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
import sys
import threading
import datetime
import tkinter
from PIL import Image,ImageTk

#変数
LType = None #実行する講義
Stop_Flag = 0 #講義の一時停止に使用
ip = None
condition = None
lecture = None
slide_count = None #スライド枚数
after_id = None #after_cancel用

# GUIの作成
root = tkinter.Tk()
root.title(u"Sota_Lecture")
root.state("zoomed") #Windowsのみ動作?
root.configure(bg="SkyBlue3")
root.update_idletasks()
#Windowサイズの取得
window_width = root.winfo_width()
window_height = root.winfo_height()

#関数
def SetLectureType(event): #実行する講義を設定
    global LType
    LType = event.widget["text"]
    label_b["text"] = "type:"+LType

def NextWindow(event): #IPアドレスの設定かつページ遷移
    global ip
    ip = EditBox.get()
    #Sotaへssh接続
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(ip)
    #ページ遷移
    screen_set.pack_forget()
    screen_lecture.pack()
    #条件と講義名を設定
    global condition
    global lecture
    if LType=="A":
        condition = "control"
        lecture = "Social"
    elif LType=="B":
        condition = "experimental"
        lecture = "History"
    elif LType=="SC":
        condition = "control"
        lecture = "Social"
    elif LType=="SE":
        condition = "experimental"
        lecture = "Social"
    elif LType=="HC":
        condition = "control"
        lecture = "History"
    elif LType=="HE":
        condition = "experimental"
        lecture = "History"
    else: #設定画面へ戻る
        screen_lecture.pack_forget()
        screen_set.pack()
    #slide_countの設定
    global slide_count
    if lecture=="Social":
        slide_count = int(11)
    elif lecture=="History":
        slide_count = int(12)
    #スライド表示
    img = Image.open("C:\worksp\sota_lecture\lecture\\"+lecture+"_slide1.jpeg") #スライド1枚目読み込み
    img_width = round(img.width * (window_height) / img.height) #アスペクト比を固定して、高さが指定した値になるようリサイズ
    tk_image = ImageTk.PhotoImage(image=img.resize((img_width, window_height))) # PhotoImage変換（jpeg用）
    canvas.create_image((window_width-(window_width//10))/2, (window_height)/2, anchor="center", image=tk_image, tag="s1") # 画像描画

def PrevWindow(event): #講義設定画面へ
    screen_lecture.pack_forget()
    screen_set.pack()
    ssh.close()

def Sota_Lecture(FileName): #Sota講義実行用（ssh接続必須）
    stdin, stdout, stderr = ssh.exec_command("cd lecture/bin && export PATH=/usr/local/bin:/usr/bin:/bin:/home/vstone/java/jdk1.8.0_40/bin:/usr/local/sbin:/usr/sbin:/sbin && chmod +x *.sh && ./java_run.sh jp/vstone/sotasample/"+FileName) #cdでは環境変数がおそらくrootのままになってしまうので、exportで変更しておく（でないと「javaが見つからない」と言われてしまう）
        # 実行結果を表示
        # stdoutは標準出力の正常結果，stderrは標準出力のエラーが出力
    for result in stdout:
        print('[std]', result, end='')
    for error in stderr:
        print('[err]', error, end='')

def Manager():
    global Stop_Flag
    global after_id
    time.sleep(5) #開始までの準備時間    
    for i in range(0,slide_count+1):
        Sota_Lecture(lecture+"_lecture_"+condition+str(i))
        while Stop_Flag==1:
            after_id = root.after(10000,print(datetime.datetime.now()))
        if i!=0 and i!=slide_count:
            next_img = Image.open("C:\worksp\sota_lecture\lecture\\"+lecture+"_slide"+str(i+1)+".jpeg") #次のスライド読み込み
            img_width = round(next_img.width * (window_height) / next_img.height) #アスペクト比を固定して、高さが指定した値になるようリサイズ
            tk_image = ImageTk.PhotoImage(image=next_img.resize((img_width, window_height))) # PhotoImage変換（jpeg用）
            canvas.create_image((window_width-(window_width//10))/2, (window_height)/2, anchor="center", image=tk_image, tag="s"+str(i+1)) # 画像描画
            canvas.delete("s"+str(i))
    canvas.delete("s"+str(slide_count))
    if LType=="A":
        condition = "experimental"
        lecture = "History"
    elif LType=="B":
        condition = "control"
        lecture = "History"




    # #classファイル（javaプロジェクト）を一時停止するプログラムをssh先で実行
    # stdin, stdout, stderr = ssh.exec_command("cd lecture/bin && export PATH=/usr/local/bin:/usr/bin:/bin:/home/vstone/java/jdk1.8.0_40/bin:/usr/local/sbin:/usr/sbin:/sbin && chmod +x *.sh && kill -s SIGSTOP 886") #cdでは環境変数がおそらくrootのままになってしまうので、exportで変更しておく（でないと「javaが見つからない」と言われてしまう）
    #     # 実行結果を表示
    #     # stdoutは標準出力の正常結果，stderrは標準出力のエラーが出力
    # for result in stdout:
    #     print('[std]', result, end='')
    # for error in stderr:
    #     print('[err]', error, end='')

def Start(event):
    thread = threading.Thread(target=Manager)
    thread.start()

def Stop_Restart(event):
    global Stop_Flag
    global after_id
    if Stop_Flag==0:
        Stop_Flag = 1
    else:
        Stop_Flag = 0
        root.after_cancel(after_id)
#     #classファイル（javaプロジェクト）を再生するプログラムをssh先で実行
#     stdin, stdout, stderr = ssh.exec_command("cd lecture/bin && export PATH=/usr/local/bin:/usr/bin:/bin:/home/vstone/java/jdk1.8.0_40/bin:/usr/local/sbin:/usr/sbin:/sbin && chmod +x *.sh && kill -s SIGCONT 886") #cdでは環境変数がおそらくrootのままになってしまうので、exportで変更しておく（でないと「javaが見つからない」と言われてしまう）
#         # 実行結果を表示
#         # stdoutは標準出力の正常結果，stderrは標準出力のエラーが出力
#     for result in stdout:
#         print('[std]', result, end='')
#     for error in stderr:
#         print('[err]', error, end='')

def SshExit(event):
    #ssh接続されている状態かどうかでif文分岐したほうが良いかも
    ssh.close()

def SshConnect(event):
    #ssh接続されている状態かどうかでif文分岐したほうが良いかも
    ssh.close()
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(ip)
    #slide_countの設定
    global slide_count
    if lecture=="Social":
        slide_count = int(11)
    elif lecture=="History":
        slide_count = int(12)
    #スライド表示
    img = Image.open("C:\worksp\sota_lecture\lecture\\"+lecture+"_slide1.jpeg") #スライド1枚目読み込み
    img_width = round(img.width * (window_height) / img.height) #アスペクト比を固定して、高さが指定した値になるようリサイズ
    tk_image = ImageTk.PhotoImage(image=img.resize((img_width, window_height))) # PhotoImage変換（jpeg用）
    canvas.create_image((window_width-(window_width//10))/2, (window_height)/2, anchor="center", image=tk_image, tag="s1") # 画像描画

# 設定画面のフレーム
screen_set = tkinter.Frame(root, bg="SkyBlue3", width=window_width, height=window_height)
screen_set.pack()
screen_set.pack_propagate(0)
# SotaのIP入力
sotaIP_frame = tkinter.Frame(screen_set, bg="SkyBlue3")
sotaIP_frame.pack(anchor="center", expand=1)
label_a = tkinter.Label(sotaIP_frame, text="Please Enter sotaIP:", bg="SkyBlue3", font=("", "14", "bold"))
label_a.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
EditBox = tkinter.Entry(sotaIP_frame, font=("", "14", ""))
EditBox.insert(tkinter.END,"192.168.1.99")
EditBox.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
# 群の選択
group_frame = tkinter.Frame(screen_set, bg="SkyBlue3")
group_frame.pack(anchor="center", expand=1)
label_b = tkinter.Label(group_frame, text="Please Select a type:", bg="SkyBlue3", font=("", "14", "bold"))
label_b.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_A = tkinter.Button(group_frame, text=u'A',font=("", "14", "bold"))
Button_A.bind("<Button-1>",SetLectureType)
Button_A.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_B = tkinter.Button(group_frame, text=u'B',font=("", "14", "bold"))
Button_B.bind("<Button-1>",SetLectureType)
Button_B.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_SC = tkinter.Button(group_frame, text=u'SC',font=("", "14", "bold"))
Button_SC.bind("<Button-1>",SetLectureType)
Button_SC.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_SE = tkinter.Button(group_frame, text=u'SE',font=("", "14", "bold"))
Button_SE.bind("<Button-1>",SetLectureType)
Button_SE.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_HC = tkinter.Button(group_frame, text=u'HC',font=("", "14", "bold"))
Button_HC.bind("<Button-1>",SetLectureType)
Button_HC.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
Button_HE = tkinter.Button(group_frame, text=u'HE',font=("", "14", "bold"))
Button_HE.bind("<Button-1>",SetLectureType)
Button_HE.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)
# 画面遷移ボタン
next_frame = tkinter.Frame(screen_set, bg="SkyBlue3")
next_frame.pack(anchor="center", expand=1)
Button_Next = tkinter.Button(next_frame, text=u'決定',font=("", "14", "bold"))
Button_Next.bind("<Button-1>",NextWindow)
Button_Next.pack(anchor="center", expand=1, side=tkinter.LEFT, padx=5, pady=5)

# 講義操作画面のフレーム
screen_lecture = tkinter.Frame(root, bg="SkyBlue3", width=window_width, height=window_height)
screen_lecture.pack()
screen_lecture.pack_propagate(0)
canvas = tkinter.Canvas(screen_lecture, bd=0, highlightthickness=0, relief='ridge', bg="black", width=window_width-(window_width//10), height=window_height) # キャンバス作成
canvas.pack(anchor="e") # キャンバス表示
#開始ボタン
Button_Stop = tkinter.Button(screen_lecture, text=u'開始',font=("", "14", "bold"), width=(window_width//150), height=(window_height//400))
Button_Stop.bind("<Button-1>",Start)
Button_Stop.place(x=(window_width//150), y=(window_height//50))
#一時停止/再生ボタン
Button_Restart = tkinter.Button(screen_lecture, text=u'一時停止/再生',font=("", "14", "bold"), width=(window_width//150), height=(window_height//400))
Button_Restart.bind("<Button-1>",Stop_Restart)
Button_Restart.place(x=(window_width//150), y=(window_height//10))
#ssh接続解除ボタン
Button_SshExit = tkinter.Button(screen_lecture, text=u'ssh接続解除', width=(window_width//80), height=(window_height//400))
Button_SshExit.bind("<Button-1>",SshExit)
Button_SshExit.place(x=(window_width//300), y=window_height-(window_height//10))
#ssh再接続/再読み込みボタン
Button_SshConnect = tkinter.Button(screen_lecture, text=u'ssh再接続/再読み込み', width=(window_width//80), height=(window_height//400))
Button_SshConnect.bind("<Button-1>",SshConnect)
Button_SshConnect.place(x=(window_width//300), y=window_height-(window_height//20))

screen_set.pack()
root.mainloop()


sys.exit()

# IPはsotaのボタンをクリックして確認して変更してください。


browser = webdriver.Chrome()# webdriver_managerによるChromeDriverの更新
browser.get("C:\worksp\sota_lecture\lecture\sota_lecture_"+condition+"0.html")
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
if condition=="control":#統制群の場合
    for i in range(0,slide_count+1):
        # Sota_Lecture("social_lecture_control"+i)
        Sota_Lecture("Social_lecture_control"+str(i))
        browser.find_element_by_id("skip-btn").click()
elif condition=="experimental":#実験群の場合
    for i in range(0,slide_count+1):
        Sota_Lecture("Social_lecture_experimental"+str(i))
        browser.find_element_by_id("skip-btn").click()
else:
    print("lecturename is wrong")

ssh.close()