CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

# Check that the file exits
if [ -f "student-submission/ListExamples.java" ]; then 
    echo "File Found!"
else 
    echo "ListExamples.java not found!"
    exit 1
fi

#jars
cp -r lib grading-area

#List Examples
cp student-submission/ListExamples.java grading-area/

#TestListExamples
cp TestListExamples.java grading-area/

cd grading-area
javac -cp $CPATH *.java > outputOfJavaC.txt 2>&1

if [ $? -ne 0 ]; then
  echo "Won't Compile"
  exit 1
else
    echo "Compiled succesfully!"
fi
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > jUnitOutput.txt

last_line=$(tail -n 3 jUnitOutput.txt)
if [[ $last_line =~ "OK" ]]; then
    echo "Grade: 100%"
    exit 0
fi

tests_run=$(echo "$last_line" | grep -o 'Tests run: [0-9]*' | awk '{print $3}')
failures=$(echo "$last_line" | grep -o 'Failures: [0-9]*' | awk '{print $2}')

correct=$((tests_run - failures))
echo "The amount correct is" 
echo $correct
echo "The amount of tests run is"
echo $tests_run
echo "Your grade is"
percentage=$(echo "scale=2; $correct / $tests_run * 100" | bc)
echo $percentage "%"




