package cloud.expertos.labs.archaws.ec2;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;

public class EjemplosSDK {

	private static final Regions REGION_DEFECTO = Regions.EU_WEST_1;

	private static final AmazonEC2 ec2 = AmazonEC2Client.builder().withRegion(REGION_DEFECTO).build();

	public static void main(String[] args) {

		String instanceId = crearInstancia(InstanceType.T2Micro, 1);
		System.out.println("Creada instancia con id: " + instanceId);

		/*
		 * String instanceId = "i-0400f3ac21ae8b513"; boolean parada =
		 * pararInstancia(instanceId); if (parada) System.out.println("La instancia: " +
		 * instanceId + " se ha detenido correctamente"); else {
		 * System.out.println("Instancia: " + instanceId +
		 * " no se ha detenido correctamente"); }
		 */
	}

	private static String crearInstancia(InstanceType instanteType, int cantidad) {
		/*
		 * CreateSecurityGroupRequest nuevoSG = new CreateSecurityGroupRequest();
		 * nuevoSG.withGroupName("WebServerSG").
		 * withDescription("WebServers Security Group");
		 * 
		 * CreateSecurityGroupResult createSecurityGroupResult =
		 * ec2.createSecurityGroup(nuevoSG);
		 */
		RunInstancesRequest rinInstanceReq = new RunInstancesRequest().withImageId("ami-0bdb1d6c15a40392c")
				.withInstanceType(instanteType).withMaxCount(cantidad).withMinCount(cantidad);

		RunInstancesResult resultado = ec2.runInstances(rinInstanceReq);

		System.out.println(resultado);

		return resultado.getReservation().getInstances().iterator().next().getInstanceId();

	}

	/*
	 * Para una instancia
	 */
	private static boolean pararInstancia(String instanceId) {
		StopInstancesResult result = ec2.stopInstances(new StopInstancesRequest().withInstanceIds(instanceId));
		return result.getStoppingInstances().iterator().next().getInstanceId().equals(instanceId);
	}

	/*
	 * Termina una instancia
	 */
	private static boolean terminarInstancia(String instanceId) {
		TerminateInstancesResult result = ec2
				.terminateInstances(new TerminateInstancesRequest().withInstanceIds(instanceId));
		return result.getTerminatingInstances().iterator().next().getInstanceId().equals(instanceId);
	}

}
