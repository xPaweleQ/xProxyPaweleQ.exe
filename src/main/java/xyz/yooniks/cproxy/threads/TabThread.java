package xyz.yooniks.cproxy.threads;

import org.spacehq.packetlib.Session;
import xyz.yooniks.cproxy.CasualProxy;
import xyz.yooniks.cproxy.managers.PlayerManager;
import xyz.yooniks.cproxy.objects.Player;

public class TabThread extends Thread {

    @Override
    public void run() {
        while (true) {
            if (CasualProxy.getPlayers().size() < 1) return;
            for (Session session : CasualProxy.getPlayers()) {
                if (!session.isConnected()) continue;
                final Player p = PlayerManager.getPlayer(session);
                p.updateTab();
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}