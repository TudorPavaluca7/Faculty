import os

from grammar_utils import read_grammar_from_file


path_to_grammar = os.path.join(os.getcwd(), 'language_grammar.txt')

grammar = read_grammar_from_file(path_to_grammar)
print(grammar)
