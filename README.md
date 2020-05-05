# Web3j, czyli jak połączyć Java z blockchain

Repozytorium zawiera materiały ze spotkania [SJUG #48](https://www.meetup.com/pl-PL/Silesia-JUG/events/267721430/).
Nagranie znajduje się [w tym miejscu](https://www.dropbox.com/s/agnxte5pvcsz0l6/SJUG%20%2031.01.2020-20200131%201630-1.mp4?dl=0).

Niezbędne narzędzia:

- klient `geth`: <https://geth.ethereum.org/downloads/>
- (opcjonalnie) kompilator `solc`: <https://solidity.readthedocs.io/>
- pakiet `web3j`: <https://docs.web3j.io/quickstart/>

Najwygodniej zmodyfikować zmienną `PATH`, aby aplikacje były dostępne z linii
komend.

Warto przeczytać:

- Blockchain Technology Overview: <https://doi.org/10.6028/NIST.IR.8202>

## Inicjalizacja i uruchomienie prywatnej instancji Ethereum

Inicjalizacja węzła

    $ geth --datadir eth init genesis.json

Uruchomienie węzła

    $ geth --datadir eth --networkid 100

Uruchomienie konsoli JavaScript

    $ geth attach eth/geth.ipc

## Konsola JavaScript

### Praca z kontami

Utworzenie konta (plik z kluczami znajduje się w `eth/keys`)

    > personal.newAccount()

Wykaz kont dostępnych na węźle

    > eth.accounts

Konto do przelewu środków uzyskanych z kopania

    > eth.coinbase

Stan konta

    > eth.getBalance(eth.coinbase)


### Kopanie

Uruchomienie i zatrzymanie procesu kopania

    > miner.start(1)
    > miner.stop()

### Zlecanie transakcji

Aby zlecać transakcje niezbędne jest odblokowanie konta źródłowego na chwilę lub
na czas sesji

    > personal.unlockAccount(eth.coinbase)
    > personal.unlockAccount(eth.coinbase, null, 0)

Wysłanie transakcji o wartości 1 ETH (należy posiadać co najmniej dwa konta
i środki na koncie `from`)

    > eth.sendTransaction({from: eth.accounts[0], to: eth.accounts[1], value: web3.toWei(1, "ether")})

Pobranie danych i informacji o transakcji (należy wstawić odpowiedni identyfikator):

    > eth.getTransaction('0xfc180c57d08f5a3be5f568ff2515e069643a8144faaa2f37dfb48be28d92d18b')
    > eth.getTransactionReceipt('0xfc180c57d08f5a3be5f568ff2515e069643a8144faaa2f37dfb48be28d92d18b')

Wysłanie transakcji z dodatkowym polem danych

    > eth.sendTransaction({from: eth.accounts[0], to: eth.accounts[1], value: web3.toWei(1, "ether"), data:'0xC0FFEE'})

### Web3.js

Kod JavaScript można również przekazywać poprzez stronę w przeglądarce używając
web3.js (<https://web3js.readthedocs.io/>). Łączy się on z węzłem np.
z wykorzystaniem WebSockets.

## Inteligentne kontrakty

Przydatne narzędzia:

- Remix <https://remix.ethereum.org/>

### Kompilacja kontraktu

Poniższe kroki są opcjonalne, wygenerowane pliki z kodem wykonywalnym i ABI
znajdują się w repozytorium.

Przygotowanie kodu wykonywalnego oraz ABI kontraktu

    $ solc --bin Greeter.sol
    $ solc --abi Greeter.sol

Przygotowanie kodu wykonywalnego oraz ABI kontraktu z zapisem do plików
w lokalnym katalogu

    $ solc --bin --abi --overwrite -o . Greeter.sol

Pomocniczy skrypt zapisujący dane dla kontraktu w formie kodu JavaScript

    $ ./sc.sh Greeter.sol

### Umieszczenie kontraktu w blockchain

Załadowanie skryptu zawierającego kod wykonywalny i ABI kontraktu
    
    > loadScript('Greeter.js')

Zlecenie transakcji utworzenia kontraktu ze zwiększonym limitem paliwa

    > greeter = Greeter.new("Hej!",{from: eth.coinbase, data: _dataGreeter, gas:250000})

Pobranie adresu kontraktu

    > greeter.address

Wywołanie funkcji niezmieniającej stanu blockchain

    > greeter.greet()

Wywołanie funkcji zmieniającej stan blockchain musi być transakcją

    > greeter.setGreeting("Serwus!", {from:eth.coinbase,gas:250000})

Jeśli kontrakt już istnieje można utworzyć zmienną reprezentującą kontrakt na
podstawie jego adresu

    > greeter = Greeter.at("0x1daf17707fd11fe40061cc71a7de5b1097970112")

## Web3j

Przykłady znajdują się w katalogu `web3j`. Można je zaimportować do ulubionego
IDE. Wykorzystywane są biblioteki zainstalowane wraz z pakietem `web3j`. Trzeba
dołączyć je do projektu.

### Praca z blockchain

Zaimplementowane przykłady znajdują się w pakiecie `piona.web3j`

- `EthConnect` - łączy się z lokalnym węzłem, sposób połączenia jest
  wykorzystywany przez pozostałe przykłady (IPC)
- `Coinbase` - pobiera podstawowe informacje o adresie konta `coinbase` z danego
  węzła
- `Account` - otwiera lokalne konto użytkownika
- `EthTransfer` - wykonuje transfer środków pomiędzy dwoma kontami
- `Monitor` - obserwuje zdarzenia związane z utworzeniem bloku

### Praca z kontraktem

Przykładowy kontrakt `DocumentRegistry.sol` służy do rejestracji skrótów
dokumentów w blockchain. Z każdym dokumentem skojarzony jest jego identyfikator
oraz czas rejestracji. Kontrakt emituje zdarzenie po każdej udanej rejestracji.

Za pomocą `web3j` trzeba wygenerować klasę opakowującą kontrakt. Ten krok jest
opcjonalny, w źródłach dołączona jest wygenerowana klasa.

    $ web3j solidity generate -b DocumentRegistry.bin -a DocumentRegistry.abi -o web3j/src -p piona.web3j.poe

Zaimplementowane przykłady znajdują się w pakiecie `piona.web3j.poe`

- `Deploy` - rejestruje kontrakt, jego adres należy zapisać w stałej do
  późniejszego użycia
- `Register` - rejestruje dokument (tekst) z wybranym identyfikatorem
- `Check` - pobiera zarejestrowane dokumenty z kontraktu i wylicza skrót
  przykładowego dokumentu
- `Events` - obserwuje zdarzenia emitowane przez kontrakt

