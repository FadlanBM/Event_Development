import DashboardLayout from '@/Layouts/DashboardLayout';
import { Head } from "@inertiajs/react";

export default function Dashboard({ auth }) {
    
    return (
        <DashboardLayout
            user={auth.user}
            header={
                <h2 className="font-semibold text-xl">
                    Dashboard
                </h2>
            }
        >
            <Head title="Dashboard" />

            <div className="pt-10 pl-10">
                <h1>sadf</h1>
            </div>
            
        </DashboardLayout>
    );
}
