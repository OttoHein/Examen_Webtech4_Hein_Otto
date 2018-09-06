# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.http import HttpResponse
from django.shortcuts import render
import urlparse
import os.path

url_list = []

def index(request):
    s = ''
    my_file =  open("mysite/movies.txt", 'r')
    response = HttpResponse(my_file.read(), content_type='text/plain')
    response['Content-Disposition'] = 'inline;filename=some_file.txt'
    s = response

    return HttpResponse(s)
