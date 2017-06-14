#!/bin/sh

zaehler=0

keyfile=../bCMSr.uml.log
outuml=../tmp/versions-uml
outall=../tmp/versions-all
umlfile=bCMS.uml
difile=bCMS.di
notationfile=bCMS.notation

cd sipl

rm -rf ${outuml}
rm -rf ${outall}
mkdir ${outuml}
mkdir ${outall}

for hashkey in `cat $keyfile`; do
    zaehler=$((zaehler+1))
    echo "checkout $hashkey ..."
    git checkout $hashkey
    ls -l casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${umlfile}   
	 if test $zaehler -lt 10
  	  then  
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${umlfile} ${outuml}/0${zaehler}-${hashkey}-${umlfile}
			mkdir ${outall}/0${zaehler}-${hashkey}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${umlfile} ${outall}/0${zaehler}-${hashkey}/${umlfile}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${difile} ${outall}/0${zaehler}-${hashkey}/${difile}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${notationfile} ${outall}/0${zaehler}-${hashkey}/${notationfile}
     else  
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${umlfile} ${outuml}/${zaehler}-${hashkey}-${umlfile}
			mkdir ${outall}/${zaehler}-${hashkey}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${umlfile} ${outall}/${zaehler}-${hashkey}/${umlfile}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${difile} ${outall}/${zaehler}-${hashkey}/${difile}
			cp casestudies/bCMS/org.sidiff.deltamodeling.casestu*y.bCMS.models/core_model_v2/${notationfile} ${outall}/${zaehler}-${hashkey}/${notationfile}
    fi		
done

ls -l $outuml
cd ..

echo fin
