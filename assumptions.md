# Assumptions

* In a real world application I would be using input validation and throw an error if input is invalid.
However, for the sake of simplicity, I am just disregarding the not-matching words from the count.

* By convention the file with the text whose words need to be count should be placed in resources.

* If we use the hexagonal (onion / clean architecture /etc.) we could have an adapter for the sake of hiding some
 information to the user. However, in my case I don't have information to hide to the user and creating an
  adapter would be make the code less readable/more verbose and more complicated to maintain and understand.
  Also, in real life I would end up using some libraries like mapstruct which would make the build heavier.
