using DemoMVC.Models;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DemoMVC.DAO
{
    public class PersonneDAO
    {
        private const string CNX_STR = @"Data Source=NXQLX140\SQLEXPRESS;Initial Catalog=demo_bch;Integrated Security=True";
        
        public void Inserer(Personne p)
        {
            // creer connection
            SqlConnection cnx = new SqlConnection();
            cnx.ConnectionString = CNX_STR;

            // creer commande
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = cnx;
            cmd.CommandText = "INSERT INTO personne (nom, prenom) VALUES (@nom, @prenom)";

            // INJECTION SQL :
            // ---------------
            //    '','');DELETE FROM personne; --
            // INSERT INTO personne (nom, prenom) VALUES ('','');DELETE FROM personne; --, qsjhfgsj)

            // ajouter params commande
            cmd.Parameters.Add(new SqlParameter("nom", p.Nom));
            cmd.Parameters.Add(new SqlParameter("prenom", p.Prenom));


            // ouvrir connection
            cnx.Open();

            // executer commande
            cmd.ExecuteNonQuery();

            // fermer connection
            cnx.Close();
        }


        public List<Personne> GetAll()
        {
            List<Personne> result = new List<Personne>();

            // creer connection
            SqlConnection cnx = new SqlConnection();
            cnx.ConnectionString = CNX_STR;

            // creer commande
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = cnx;
            cmd.CommandText = "SELECT * FROM personne";

            // ouvrir connection
            cnx.Open();

            // executer commande
            SqlDataReader dr = cmd.ExecuteReader();

            while(dr.Read())
            {
                Personne p = new Personne();
                p.Id = dr.GetInt32(dr.GetOrdinal("Id"));
                p.Nom = dr.GetString(dr.GetOrdinal("Nom"));
                p.Prenom = dr.GetString(dr.GetOrdinal("Prenom"));
                
                result.Add(p);
            }

            // fermer connection
            cnx.Close();

            return result;
        }
    }
}
