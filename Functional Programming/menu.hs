import System.IO
import qualified System.Process as SP

clearScreen :: IO ()
clearScreen = do
  _ <- SP.system "reset"
  return ()

main :: IO()
main = do
    clearScreen
    putStrLn "                                   Menu\n"
    putStrLn "               Selecione a implementação que deseja utilizar:\n"
    putStrLn "                             1. Multiset-List"
    putStrLn "                             2. Multiset-Map\n"

    implementation_option <- getLine

    clearScreen
    putStrLn "                                   Menu\n"
    putStrLn "                  Selecione qual função deseja utilizar:\n"
    putStrLn "                             1. insert elem bag\n"
    putStrLn "                             2. remove elem bag\n"
    putStrLn "                             3. search elem bag\n"
    putStrLn "                             4. union bag1 bag2\n"
    putStrLn "                             5. intersection bag1 bag2\n"
    putStrLn "                             6. minus bag1 bag2\n"
    putStrLn "                             7. inclusion bag1 bag2\n"
    putStrLn "                             8. minus bag1 bag2\n"
    putStrLn "                             9. sum bag1 bag2\n"
    putStrLn "                            10. size bag\n"

    method <- getLine

    putStrLn "     Forneça o(s) parâmetro(s) da função escolhida:\n"

    parameters <- getLine

    if implementation_option == 1
    then let implementation = "List"
    else let implementation = "Map"


    putStrLn $ "Você deseja testar a função" ++ method ++ "da implementação de Multiset-" ++ implementation ++ "com o(s) parâmetro(s): " ++ parameters