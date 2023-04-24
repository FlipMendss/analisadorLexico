program VerificaPrimo;

var
num, i, count: integer;

begin
write('Digite um número inteiro positivo: ');
readln(num);
count := 0;
for i := 1 to num do
begin
if (num mod i = 0) then
count := count + 1;
end;
if (count = 2) then
writeln(num, ' é um número primo')
else
writeln(num, ' não é um número primo');
end.