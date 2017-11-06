package hudson.plugins.ec2;

import hudson.model.Node;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertEquals;

import org.jenkinsci.plugins.cloudstats.ProvisioningActivity;

public class EC2OndemandSlaveTest {

    @Rule
    public JenkinsRule r = new JenkinsRule();

    @Test
    public void testSpecifyMode() throws Exception {
    	final ProvisioningActivity.Id provisioningIdNormal = new ProvisioningActivity.Id("cloud", "template");
        EC2OndemandSlave slaveNormal = new EC2OndemandSlave(provisioningIdNormal, "instanceId", "description", "remoteFS", 1, "labelString", Node.Mode.NORMAL, "initScript", "tmpDir", "remoteAdmin", "jvmopts", false, "30", "publicDNS", "privateDNS", null, "cloudName", false, false, 0, new UnixData("a", null, "b"));
        assertEquals(Node.Mode.NORMAL, slaveNormal.getMode());
        final ProvisioningActivity.Id provisioningIdExclusive = new ProvisioningActivity.Id("cloud", "template");
        EC2OndemandSlave slaveExclusive = new EC2OndemandSlave(provisioningIdExclusive, "instanceId", "description", "remoteFS", 1, "labelString", Node.Mode.EXCLUSIVE, "initScript", "tmpDir", "remoteAdmin", "jvmopts", false, "30", "publicDNS", "privateDNS", null, "cloudName", false, false, 0, new UnixData("a", null, "b"));
        assertEquals(Node.Mode.EXCLUSIVE, slaveExclusive.getMode());
    }

}
