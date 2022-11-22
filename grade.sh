# Create your grading script here

rm -rf student-submission 

git clone $1 student-submission 

CPATH=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
cd student-submission 
if [[ -e ListExamples.java ]]
then
    echo "Correct files submitted" 
else
    echo "Wrong files submitted! Score 0/4"
    exit
fi

cp ../TestListExamples.java ./ 
javac -cp $CPATH *.java 
if [[ $? -eq 0 ]]
then   
    echo "Successfully Compiled" 
else   
    echo "Compile Error! Score 0/4" 
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > ../result.txt

cd ../
grep "Failures: 1" result.txt
if [[ $? -eq 0 ]]
then 
    echo "Score: 3/4"
    exit
fi
grep "Failures: 2" result.txt
if [[ $? -eq 0 ]]
then 
    echo "Score: 2/4"
    exit
fi
grep "Failures: 3" result.txt
if [[ $? -eq 0 ]]
then 
    echo "Score: 1/4"
    exit
fi
grep "Failures: 4" result.txt
if [[ $? -eq 0 ]]
then 
    echo "Score: 0/4"
    exit
fi

echo "Great Work! Score: 4/4"