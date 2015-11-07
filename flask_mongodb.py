from flask import Flask
from flask.ext.pymongo import PyMongo
from flask import render_template
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient()
db = client.test

@app.route('/')
def home_page():
    return render_template('homepage.html')

@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)

if __name__ == '__main__':
    app.run()