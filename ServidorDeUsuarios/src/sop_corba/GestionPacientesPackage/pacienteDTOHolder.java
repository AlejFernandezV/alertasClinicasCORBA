package sop_corba.GestionPacientesPackage;

/**
* sop_corba/GestionPacientesPackage/pacienteDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from paciente_operaciones.idl
* jueves 30 de noviembre de 2023 12:28:27 PM COT
*/

public final class pacienteDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.GestionPacientesPackage.pacienteDTO value = null;

  public pacienteDTOHolder ()
  {
  }

  public pacienteDTOHolder (sop_corba.GestionPacientesPackage.pacienteDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.GestionPacientesPackage.pacienteDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.GestionPacientesPackage.pacienteDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.GestionPacientesPackage.pacienteDTOHelper.type ();
  }

}
