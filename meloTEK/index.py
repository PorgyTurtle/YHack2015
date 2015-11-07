from flask import Flask, render_template, request, redirect
import os
from pymongo import MongoClient

def connect():
    connection = MongoClient("0.0.0.0",27017)
    db = connection["musicdb"]
    return db

app = Flask(__name__)
db = connect()

# bind index page to both localhost:5000 and localhost:5000/index
@app.route('/index', methods=['GET'])
@app.route('/', methods=['GET'])
def index():
    userinputs = [x for x in db.mycollection.find()]
    return render_template('index.html', userinputs=userinputs)

@app.route('/write', methods=['POST'])
def write():
    userinput = request.form.get('userinput')
    password = request.form.get('password')
    old = db.mycollection.insert({'message':userinput})
    return redirect('/')

@app.route('/sign_up', methods=['GET','POST'])
def sign_up():
    return render_template('sign_up.html')

@app.route('/about')
def about():
    return render_template('about.html')

@app.route('/deleteall', methods=['GET'])
def deleteall():
    db.mycollection.remove()
    return redirect('/')

if __name__ == '__main__':
    # bind to PORT if defined, otherwise default to 5000
    port = int(os.environ.get('PORT',5000))

    app.run(host='0.0.0.0',port=port,debug=True)