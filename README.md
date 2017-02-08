# AttributeSemanticSimilarity

Create a project Directory and run the following command:
git clone https://github.com/Debanjan-Paul/AttributeSemanticSimilarity.git

Change directory to the project folder and then run the following command:
mvn clean install assembly:single

Now make a folder named "output" in the same directory [mkdir output]

Run train.java for training the word2vec model with the input file as argument.

The input file must be a text file containing plain review texts only i.e. it will contain each review text(review body only) per line only.
It will generate an output file containing the saved model named "pathToSaveModelnew.txt".

Now run word2vec.java with "pathToSaveModelnew.txt" provided as first argument and "annote.txt" as second argument. "annote.txt" is generated 
as output from previous ReviewAspectExtraction module.
This phase will write the review aspect distribution matrix in a file named "featureDistributionMatrix.txt" in the output folder.This file 
needs to be provided as input to our next Review Recommendation phase.
