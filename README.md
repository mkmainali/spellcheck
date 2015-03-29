# spellcheck
This is a simple spell checking program implemented in Java. The algorithm behind the spell checking is based on one explained by Peter Norvig at the following page:

http://norvig.com/spell-correct.html

#How to use

## Training data
The implementation comes with a FileReader for training data, which requires a path to a file. You can also provide your own that implements the Reader interface.

## Tokenizer
The default tokenizer is whitespace tokenizer. If you want to use your custom tokenizer, then you can provide one that implements the Tokenizer interface. 

## Filters
You have option to apply filters to the tokens emitted by tokenizer. Some implementations provided are StopwordFilter, SingleCharacterFilter, NonAlphabetFilter and LowercaseFilter. You can implement your own filter by implementing the Filter interface.

LowercaseFilter: transforms the characters to lower case

StopwordFilter: Removes the stopwords 

SingleCharacterFilter: Removes all the single character tokens

NonAlphanumericFilter: This filter splits the string based on regex "[^a-zA-Z0-9]". 


## Use case example

Following is an use case example where the training data is just three words (not practical at all!)

```
SpellCheck checker = new SpellCheckBuilder().withReader(new Reader() {
            @Override
            public Iterator<String> getTrainingData() throws SpellcheckException {
                return Arrays.asList("correction", "spelling", "coding").iterator();
            }
        }).build();

checker.correct("corection");
        
```
The above spell checker would return "correction" when the incorrect word is "corection".

