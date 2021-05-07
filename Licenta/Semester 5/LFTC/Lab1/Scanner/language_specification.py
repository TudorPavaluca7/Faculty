separators = ['[', ']', '{', '}', '(', ')', ';', ' ', ',']
operators = ['+', '-', '*', '/', '<', '<=', '=', '>=', '>', '==', '&&', '||', '!', '!=', '++', '--']
reservedWords = ['array', 'char', 'else', 'if', 'int', 'bool', 'read', 'while', 'write', 'float', 'string', 'return']

everything = separators + operators + reservedWords
codification = dict([(everything[i], i + 2) for i in range(len(everything))])
codification['identifier'] = 0
codification['constant'] = 1