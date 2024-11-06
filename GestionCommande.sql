CREATE TABLE Client (
    numCl SERIAL PRIMARY KEY,
    nomCl VARCHAR(50) NOT NULL,
    prenomCl VARCHAR(50) NOT NULL,
    adresseCl VARCHAR(100),
    telCl VARCHAR(15)
);
CREATE TABLE Commande (
    numCom SERIAL PRIMARY KEY,
    dateCom DATE NOT NULL,
    client_id INTEGER NOT NULL,
    FOREIGN KEY (client_id) REFERENCES Client(numCl) ON DELETE CASCADE
);
CREATE TABLE Facture (
    numFact SERIAL PRIMARY KEY,
    dateFact DATE NOT NULL,
    montant DECIMAL(10, 2) NOT NULL,
    commande_id INTEGER NOT NULL,
    FOREIGN KEY (commande_id) REFERENCES Commande(numCom) ON DELETE CASCADE
);
CREATE TABLE Article (
    codeArt SERIAL PRIMARY KEY,
    desArt VARCHAR(100) NOT NULL,
    couleur VARCHAR(20),
    puArt DECIMAL(10, 2) NOT NULL,
    qteStock INTEGER NOT NULL
);
CREATE TABLE Utilisateur (
    codeUt SERIAL PRIMARY KEY,
    nomUt VARCHAR(50) NOT NULL,
    prenomUt VARCHAR(50) NOT NULL,
    fonction VARCHAR(50)
);
CREATE TABLE Facture_Article (
    numfact INTEGER NOT NULL,
    codeart INTEGER NOT NULL,
    numcom INTEGER NOT NULL,
    qtecom INTEGER NOT NULL,
    PRIMARY KEY (numfact, codeart, numcom),
    FOREIGN KEY (numfact) REFERENCES Facture(numFact) ON DELETE CASCADE,
    FOREIGN KEY (codeart) REFERENCES Article(codeArt) ON DELETE CASCADE,
    FOREIGN KEY (numcom) REFERENCES commande(numcom) ON DELETE CASCADE;
);
