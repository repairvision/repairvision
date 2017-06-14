#!/bin/sh

git log --pretty=%h --follow casestudies/bCMS/org.sidiff.deltamodeling.casestudy.bCMS.models/core_model_v2/bCMS.uml > ../bCMSr.uml.log
tac bCMS.uml.log > bCMSr.uml.log
