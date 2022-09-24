<html>
<body>
<h2>Hello World!</h2>

<form action="getAll" method="get">
<input type="submit" value="Vidi sve reci">
</form>

<form action="getAllResults" method="get">
<input type="submit" value="Vidi sve rezultate">
</form>

<form action="formPairs" method="get">
<input type="text" name = "prvaRec" placeholder="Pocetna rec">
<input type="text" name="drugaRec" placeholder="Rec za pronaci">
<input type="submit" value="Vidi rezultat za date reci">
</form>

<form action="findById" method="get">
<input type="text" name="idb" placeholder="Upisi id">
<input type="submit" value="Pronadji reci i rezultat preko ID-a">
</form>

<form action="deleteById" method="get">
<input type="text" name="id" placeholder="Upisi id">
<input type="submit" value="Obrisi reci i rezultat preko ID-a">
</form>

</body>
</html>
